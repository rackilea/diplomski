#foreach ($i in [0..100000])
    #set ($line = false)
    #set ($line = $body.readLine())
    #if ($line)
        ${line}
    #else
        #break
    #end
#end