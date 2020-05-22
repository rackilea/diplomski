#macro ( test $attr )
    #set($attr = $attr)

    1 $attr.edd
    #set($attr.edd = "edd")
    2 $attr.edd

    #set($foo = {"bar" : "bar" })
    3 $foo.edd
    #set($foo.edd = "edd")
    4 $foo.edd
#end

#test({"bar" : "bar" })