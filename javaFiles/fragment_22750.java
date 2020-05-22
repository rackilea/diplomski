<searchConfiguration name="deprecated class" text="@Deprecated class $C$ {} " recursive="true" caseInsensitive="true" type="JAVA" pattern_context="default">
 <constraint name="__context__" within="" contains="" />
 <constraint name="C" within="" contains="" />
</searchConfiguration>


<searchConfiguration name="reference to deprecated class" text="$ref$" recursive="true" caseInsensitive="true" type="JAVA" pattern_context="default">
 <constraint name="__context__" within="" contains="" />
 <constraint name="ref" reference="deprecated class" within="" contains="" />
</searchConfiguration>