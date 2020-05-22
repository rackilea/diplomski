$("#cropbox").load(function(){
            $('#cropbox').Jcrop({
                onChange: updateCoords,
                onSelect: updateCoords
            });
  });