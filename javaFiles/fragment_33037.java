List<Term> terms = new ArrayList<Term>();
// ...

while (resultSet.next()) {
    Term term = new Term();
    term.setCode(resultSet.getString("val_internal_code"));
    term.setDescription(resultSet.getString("val_internal_representation"));
    term.setSorter(resultSet.getInt("sorter"));
    term.setDate(resultSet.getDate("sDate"));
    terms.add(term);
}

// ...
request.setAttribute("terms", terms);