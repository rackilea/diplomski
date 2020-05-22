commands.add ( "C:\\Program Files\\CCBU\\CCBU.exe"                      );
                commands.add ( "-d");
                commands.add ("C:\\My Data\\projects\\ccbu\\ciccb-report.xls"        );
                commands.add ( "-tf");
                commands.add("C:\\Program Files\\CCBU\\loss-billing-filters.txt"   );
                commandExecutor = new SystemCommandExecutor(commands);