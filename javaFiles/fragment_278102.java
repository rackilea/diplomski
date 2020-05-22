<!-- 
The name of a JSP bean scope within which such a form bean may be accessed.
-->
<!ENTITY % RequestScope "(request|session)">
...
...
<!ATTLIST action   scope    %RequestScope;  #IMPLIED>