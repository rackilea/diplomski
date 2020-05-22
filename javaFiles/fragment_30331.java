private function setWidthForLongdata():void {
        var width:int;
        width = selectedzone.width;
        var maxWidth:int;
        maxWidth = width + (width/2);

        for each (var zone:ZoneVO in slotProxy.slotWizardVo.currentZones.source) {
        if(zone.zoneName.length > maxLen ) {
        maxLen = zone.zoneName.length;
        }
        }

        if(maxLen*13 > width) {
        width = maxLen*13;

        if(width>maxWidth) {
        width = maxWidth;
        }
        }
        selectedzone.dropdown.width=width;
        }