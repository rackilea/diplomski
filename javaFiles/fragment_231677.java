local-part      =   dot-atom / quoted-string / obs-local-part
atext           =   ALPHA / DIGIT /    ; Printable US-ASCII
                   "!" / "#" /        ;  characters not including
                   "$" / "%" /        ;  specials.  Used for atoms.
                   "&" / "'" /
                   "*" / "+" /
                   "-" / "/" /
                   "=" / "?" /
                   "^" / "_" /
                   "`" / "{" /
                   "|" / "}" /
                   "~"

atom            =   [CFWS] 1*atext [CFWS]

dot-atom-text   =   1*atext *("." 1*atext)

dot-atom        =   [CFWS] dot-atom-text [CFWS]

...