Actually i send the request in ajax so only it's not working after that i change the request.




 var serverURL = hURL + "/rup";
            var parameters = "requestType=port&subRequestType=portScen&userName=" + userName + "&scen=" + selectedScen;
            $.ajax({
                type: "POST",
                data: parameters,
                url: serverURL,
                cache:false,
                dataType:"html",
                success: function() {
                    updateStatusMessage("success", "Scen port successfully");
                },
                async:false
            });

Solution of the problem:

var serverURL = hURL + "/rpp?requestType=port&subRequestType=portScen&userName=" + userName + "&scen=" + selectedScen;
window.open(serverURL, '_blank');