String[] numbers = SSPparagraphs.text().toString().split(" ");
        String[] numbers1 = SBPparagraphs.text().toString().split(" ");

        //generate table and column heads
        String formattedText = new String("<html><table><tbody>");
        formattedText += "<tr><th>SSP</th><th>SBP</th></tr>";

        //populate table with data in two columns
        //will account for differing amounts of data between SBP and SSP
        int x = 0;
        while (x < numbers.length || x < numbers1.length)
        {
            formattedText += "<tr><td>";

            if (x < numbers.length)
            {
                formattedText += numbers[x];
            }
            else
            {
                formattedText += " ";
            }

            formattedText += "</td><td>";

            if (x < numbers1.length)
            {
                formattedText += numbers1[x];
            }
            else
            {
                formattedText += " ";
            }

            formattedText += "</td></tr>";

            x++;
        }

        formattedText += "<tbody></table>";