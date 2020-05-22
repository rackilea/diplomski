#foreach($field in $fields)
#set($name = $StringUtil.capitalizeWithJavaBeanConvention($StringUtil.sanitizeJavaIdentifier($helper.getPropertyName($field.element, $project))))
#if ($field.boolean && $field.primitive)
#set($getter = "is${name}")
#else
#set($getter = "get${name}")
#end
#set($setter = "set${name}")
#if($field.modifierStatic)
static ##
#end

#if($field.modifierStatic)
static ##
#end
Optional<$field.type> ##
${getter}() {
  return Optional.fromNullable($field.name);
}

#if($field.modifierStatic)
static ##
#end
void ${setter}($field.type $paramName) {
#if ($field.name == $paramName)
    #if (!$field.modifierStatic)
    this.##
    #else
        $classname.##
    #end
#end
$field.name = $paramName;
}
#end