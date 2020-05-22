String input =
    "\"1234\"|\"Name\"||\"Some description with ||| in it\"|\"Last Column\"";
//  \_______/ \______/\/\_________________________________/ \_____________/    
//      1        2    3                 4                          5

int cols = input.replaceAll("\"[^\"]*\"", "")  // remove "..."
                .replaceAll("[^|]", "")        // remove anything else than |
                .length() + 1;                 // Count the remaining |, add 1

System.out.println(cols);   // 5