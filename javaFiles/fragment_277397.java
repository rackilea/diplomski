$(document).ready(
        function() {
            $("#tabstrip").kendoTabStrip({
                animation : {
                    open : {
                        effects : "fadeIn"
                    }
                },
                select: onSelect
            }).data("kendoTabStrip");

            $(".panelbar").kendoPanelBar({
            });

            function onSelect(e) {
                loadDetails($(e.item).text());
            }

            function loadDetails(tab) {
                event.preventDefault();
                if(tab.length > 0) {
                    if(tab == 'Tab1') {
                        if(document.getElementById('Tab1Frame').src == '') {
                            document.getElementById('Tab1Frame').src = "${pageContext.servletContext.contextPath}/controller1.do";
                            document.getElementById('Tab12Frame').src = "${pageContext.servletContext.contextPath}/controller12.do";
                        }
                    } else if(tab == 'Tab2') {
                        if(document.getElementById('Tab2Frame').src == '') {
                            document.getElementById('Tab2Frame').src = "${pageContext.servletContext.contextPath}/controller2.do";
                        }
                    }
                }
            }
        });