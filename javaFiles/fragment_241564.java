virtualServerMonitoringProbeService.chainUnchainE1T1().update( {
                id: $route.current.params.id,
                cardId: cardId,
                interfaceId: interfaceId
            }, {'chained' : true}).$promise.then( function (resp) {
                    messageNotificationFactory.setNotification('success', resp.message);
                })
                ,
                function (error) {
                    messageNotificationFactory.setNotification('error', error.data.message)
                }