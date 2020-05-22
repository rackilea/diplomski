String input = 
"[what, ask, about, group, differences, , , or, differences, in, conditions, |? |]";

System.out.println(
    input
        // replaces
        //           | comma+space not preceded/followed by other comma
        //           |                 | with space
        .replaceAll("(?<!, ), (?!,)", " ")
        // replaces
        //           | 3 consecutive comma+spaces
        //           |          | with single comma+space
        .replaceAll("(, ){3}", ", ")
);