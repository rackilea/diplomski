//                  Matches 29 chars    Matches 30 chars plus suffix
//                        |                      |
//                ----------------------------------------------
//                |               ||                           |
String pattern = "([A-Z\\d]{1,29})|([A-Z\\d]{30}([A-Z]\\d){0,1})";
//                 ^^^^^^^^         ^^^^^^^^