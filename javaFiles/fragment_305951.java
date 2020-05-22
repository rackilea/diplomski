$.post("/csm/compare.action",
          { 
            sessiontoken: sessiontoken,
            compareCategory: "system",
            compareSubCategory:"patch",
            xml1:absP[0],
            xml2:absP[1]},
              function(data)
              {
                data = $.parseJSON(data);

                alert(data.response[0].elementName);
}
        );