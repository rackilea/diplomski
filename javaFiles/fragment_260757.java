<?page title="try using generic composer" contentType="text/html;charset=UTF-8"?>
<?script src="/js/tryhttp_v2.js" ?>
<zk xmlns="http://www.zkoss.org/2005/zul">
    <window id="info" apply="foo.TryHttpV2" xmlns:w="client"> 
        <button id="btnExec" w:onClick="sendToServer();" label="to be tested button" /> 
    </window>
</zk>