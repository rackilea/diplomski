//given:
final InputStream html = getClass().getClassLoader().getResourceAsStream("table.html");

//when:
final Document document = Jsoup.parse(html, "UTF-8", "/");

final List<List<String>> result = document.select("table tr")
    .stream()
    // Select all <td> tags in single row
    .map(tr -> tr.select("td"))
    // Repeat n-times those <td> that have `colspan="n"` attribute
    .map(rows -> rows.stream()
        .map(td -> Collections.nCopies(td.hasAttr("colspan") ? Integer.valueOf(td.attr("colspan")) : 1, td))
        .flatMap(Collection::stream)
        .collect(Collectors.toList())
    )
    // Fold final structure to 2D List<List<Element>>
    .reduce(new ArrayList<List<Element>>(), (acc, row) -> {
        // First iteration - just add current row to a final structure
        if (acc.isEmpty()) {
            acc.add(row);
            return acc;
        }

        // If last array in 2D array does not contain element with `rowspan` - append current
        // row and skip to next iteration step
        final List<Element> last = acc.get(acc.size() - 1);
        if (last.stream().noneMatch(td -> td.hasAttr("rowspan"))) {
            acc.add(row);
            return acc;
        }

        // In this case last array in 2D array contains an element with `rowspan` - we are going to
        // add this element n-times to current rows where n == rowspan - 1
        final AtomicInteger index = new AtomicInteger(0);
        last.stream()
            // Map to a helper list of (index in array, rowspan value or 0 if not present, Jsoup element)
            .map(td -> Arrays.asList(index.getAndIncrement(), Integer.valueOf(td.hasAttr("rowspan") ? td.attr("rowspan") : "0"), td))
            // Filter out all elements without rowspan
            .filter(it -> ((int) it.get(1)) > 1)
            // Add all elements with rowspan to current row at the index they are present 
            // (add them with `rowspan="n-1"`)
            .forEach(it -> {
                final int idx = (int) it.get(0);
                final int rowspan = (int) it.get(1);
                final Element td = (Element) it.get(2);

                row.add(idx, rowspan - 1 == 0 ? (Element) td.removeAttr("rowspan") : td.attr("rowspan", String.valueOf(rowspan - 1)));
            });

        acc.add(row);
        return acc;
    }, (a, b) -> a)
    .stream()
    // Extract inner HTML text from Jsoup elements in 2D array
    .map(tr -> tr.stream()
        .map(Element::text)
        .collect(Collectors.toList())
    )
    .collect(Collectors.toList());