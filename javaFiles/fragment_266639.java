$scriptBlock = {java -Xdebug                                                         <# This is comment param 1 #>`
                     -Xrunjdwp:server=y,transport=dt_socket,address=4000,suspend=n   <# This is comment param 1 #>`
                     `"$($args[0])`"}                                                <# Application Path #>

$ApplicationName = "c:\un chemin applicatif\toto"
Invoke-Command -ScriptBlock $scriptBlock  -ArgumentList $ApplicationName