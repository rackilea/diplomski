<!DOCTYPE html [
  <!ELEMENT html - - (head,body)>
  <!ELEMENT head - - (#PCDATA)>
  <!ELEMENT body - - (div+)>
  <!ELEMENT div - - (#PCDATA)>
  <!ENTITY myxhtml SYSTEM "myxhtml.xml">
]>
&myxhtml;