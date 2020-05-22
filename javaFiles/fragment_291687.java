File outFile = new File("temperature_table.text");
            PrintWriter pw = new PrintWriter(outFile);
            for (double i = 40; i >= 31; i--) {                   

                pw.println("celsius  \tFahrenheit \t|       Fahrenheit \tCelsius");
                double cTf = (double) Math.round(celsiusToFahrenheit(i) * 100) / 100;
                double decimal = (double) Math
                        .round(fahrenheitToCelsius(j) * 100) / 100;
                pw.println(i + "\t\t" + cTf + "\t\t|" + "\t" + j + "\t" + "\t"
                        + decimal);
                System.out.println("");
                j -= 10;
            }
            pw.close();