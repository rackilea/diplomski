<zk>
    <script><![CDATA[
    zk.afterLoad('zul.db', function () {
    var _xRenderer = {};
    zk.override(zul.db.Renderer, _xRenderer, {
    titleHTML: function (wgt, out, localizedSymbols) {
    _xRenderer.titleHTML.apply(this, arguments); //call the original method
    var uuid = wgt.uuid,
       view = wgt._view,
       text = wgt.getZclass() + '-ctrler';

    if(view == 'day') {
    out.push('<button id="', uuid, '-today" class="', text, '"', 
    ' onClick="var cal = zk.Widget.$(\'$', wgt.parent.id, '\')._pop; cal._value = null; cal._setTime();"',
    ' >', ' today', '</button>');
    }
              out.push('<button id="', uuid, '-clear" class="', text, '"', 
    ' onClick="clearDatebox(this)"',
    ' >', ' clear', '</button>');
    }
    });
    });
    function clearDatebox (btn) {
        var id = jq('.z-datebox-pp')[0].id.replace('-pp', ''),
            dbx = zk.Widget.$('#' + id);
        dbx.getInputNode().value = '';
        dbx.updateChange_();
    }
    ]]></script>
    <datebox id="db" ></datebox>
</zk>