// One Load object
function Load(args) {
    this.kind = args.kind || null; // Location or Magnitude
    this.value = args.value || null;
    this.clazz = args.clazz || null;
}


    var arr = new Array();
      var loads = document.getElementsByName('load');
   for (var i=0; i< loads.length; i++) {

    arr[i] = new Load({
                kind: loads[i].id,
                value: loads[i].value.
                clazz: loads[i].getAttribute('class').
    });
   }