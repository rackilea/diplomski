while((stdOut = brStdOut.readLine())  != null)
                {
                    System.out.println(stdOut);
                }
                while((errorStream = brErrorStream.readLine()) != null)
                {
                    System.err.println(errorStream);
                }