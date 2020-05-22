#set($valToKey = {})
$!valToKey.put("aaa", ["bbb", "ccc"])
$!valToKey.get("aaa").add("ddd")

## fill valToKey map
#foreach($item in $tmp.entrySet())
    #foreach($value in $item.value)
        #if($valToKey.containsKey($value))
            $!valToKey.get($value).add($item.key) ## use of dummy to prevent printing 'true'
        #else
            $!valToKey.put($value, [$item.key])
        #end
    #end
#end

## print valToKey map
#foreach($item in $valToKey.entrySet())

    $item.key
    ## print all values according to key
    #foreach($value in $item.value)
        $indent  -> $value
    #end
#end