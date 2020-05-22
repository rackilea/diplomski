Elements content = doc.select("div.views-field >span");
for (Element viewField : content) {
    /*
        each viewField corresponds to one
        <div class="views-field views-field-php"> 
          <span class="field-content">
            <a href="/Recalls/2018/BSH-Home-Appliances-amplía-retiro-del-mercado-de-lavavajillas">
            <div class="date">
              October 20, 2017
            </div>
            ...
          </span>
        </div>
    */
    Elements divs = viewField.getElementsByTag("div");
    for (Element div : divs) {
      String className = div.className();
      if (className.equals("date")) {
        // store and extract date
      } else if (className.equals("...")) {
        // do something else
      } // else...
    }
}