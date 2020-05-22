// Get all filenames from PHP include variations and return in array.
function getIncludes($text) {
    $count = preg_match_all('/
        # Match PHP include variations with single string literal filename.
        \b              # Anchor to word boundary.
        (?:             # Group for include variation alternatives.
          include       # Either "include"
        | require       # or "require"
        )               # End group of include variation alternatives.
        (?:_once)?      # Either one may be the "once" variation.
        \s*             # Optional whitespace.
        (               # $1: Optional opening parentheses.
          \(            # Literal open parentheses,
          \s*           # followed by optional whitespace.
        )?              # End $1: Optional opening parentheses.
        (?|             # "Branch reset" group of filename alts.
          \'([^\']+)\'  # Either $2{1]: Single quoted filename,
        | "([^"]+)"     # or $2{2]: Double quoted filename.
        )               # End branch reset group of filename alts.
        (?(1)           # If there were opening parentheses,
          \s*           # then allow optional whitespace
          \)            # followed by the closing parentheses.
        )               # End group $1 if conditional.
        \s*             # End statement with optional whitespace
        ;               # followed by semi-colon.
        /ix', $text, $matches);
    if ($count > 0) {
        $filenames = $matches[2];
    } else {
        $filenames = array();
    }
    return $filenames;
}