#set ($vcontextCopy = {})
$!vcontextCopy.putAll($vcontext)
#foreach ($entry in $vcontextCopy.entrySet())
  ## Prevent infinite recursion, don't print the whole context again
  #if ($entry.key != 'vcontext' && $entry.key != 'vcontextCopy')
    $entry.key => $entry.value
  #end
#end