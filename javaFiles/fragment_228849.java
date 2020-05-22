oVizFrame.setVizProperties({
    plotArea: {
        dataLabel: { renderer: function(oConfig){
            if(oConfig.val === 0){
                oConfig.text = "";
            }
        } }
    }
});