#foreach($msg in $alerts)
<div class="dashboard-alert alert alert-${msg.type}" >
    #if( $msg.id )    
      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
      <a class="hide msg" href="$msg.href">Ack</a>
    #end
    $msg.body
</div>
#end