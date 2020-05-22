<property-provider name="user.agent"><![CDATA[
      var ua = navigator.userAgent.toLowerCase();
      var makeVersion = function(result) {
        return (parseInt(result[1]) * 1000) + parseInt(result[2]);
      };

      if (ua.indexOf("opera") != -1) {
        return "opera";
      } else if (ua.indexOf("webkit") != -1) {
        return "safari";
      } else if (ua.indexOf("msie") != -1) {
        if (document.documentMode >= 8) {
          return "ie8";
        } else {
          var result = /msie ([0-9]+)\.([0-9]+)/.exec(ua);
          if (result && result.length == 3) {
            var v = makeVersion(result);
            if (v >= 6000) {
              return "ie6";
            }
          }
        }
      } else if (ua.indexOf("gecko") != -1) {
        var result = /rv:([0-9]+)\.([0-9]+)/.exec(ua);
        if (result && result.length == 3) {
          if (makeVersion(result) >= 1008)
            return "gecko1_8";
          }
        return "gecko";
      }
      return "unknown";
  ]]></property-provider>