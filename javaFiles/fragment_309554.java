<div id="appletContainer" runat="server" style="width:(document.body.clientWidth - 270);height:300" clientidmode="Static">
    <script type="text/javascript">
        // Wrap your code with a function called loadApplet
        function loadApplet() {
            // Your applet loading code:
            var showCI = 0;                                        
            if (document.getElementById("hdnHas3D").value == "1" && !isAppleMobile()) {
                var J3DStyleID = document.getElementById("hdn3DStyleID").value;
                var code = "com.wirefusion.player.AppletPlayer";
                var archiveList = "Some achive List";                                         
                var width = document.body.clientWidth - 270;
                var height = 300; 

                var attributes = {
                    id: "appletContainerX",
                    name: J3DStyleID,
                    code: code,
                    codebase: ".",
                    width: width,
                    height: height,
                    mayscript: "true"
                };
                var parameters = {
                    progressFunc: "handleAppletProgress",
                    archive: archiveList,
                    java_arguments: "-Xmx200m",
                    regid: "6050-25",                                                
                    resourcefolder: "/RichContent/3D_Vehicles/J3D/Vehicles/" + J3DStyleID + "/",
                    preloadfile: J3DStyleID + ".jar",
                    environmentType: "WEBSITE",
                    environmentWidth: width,
                    environmentHeight: height,
                    groupsXMLFile: "../../Resources/groups.xml",
                    vehicleXMLFile: J3DStyleID + ".xml"
                };
                var version = '1.6.0_20'; 
                if (deployJava.versionCheck(version + '+')) {
                    docWriteWrapper(function () {
                        deployJava.runApplet(attributes, parameters, version);
                    });                                               
                } else {
                    if (document.getElementById("iframeContainer").style.display != "none") {
                        alert("Unable to load Interactive mode");
                        showCI = 1;

                    }
                }
            }

        }
    </script>
</div>