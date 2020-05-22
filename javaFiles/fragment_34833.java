<!-- Absolute paths -->
<property name="myprop" value="${basedir}/x" />
<property name="myprop2" value="${basedir}/x:${basedir}/y" />

<!-- Convert single path to relative to basedir -->
<property name="myprop_rel" location="${myprop}" relative="yes"/>

<!-- Go via path/pathconvert for the property with multiple paths -->
<path id="mypath2" path="${myprop2}" />
<pathconvert property="myprop2_rel" refid="mypath2" pathsep=",">
    <map from="${basedir}/" to="" />
</pathconvert>

<fileset id="my_fileset" dir="." includes="${myprop2_rel}" />