val doubleClickLastTime = 0L
view.setOnClickListener
run({ if (System.currentTimeMillis() - doubleClickLastTime < 300)
     {
       doubleClickLastTime = 0
       doAction()
     }
     else
     {
       doubleClickLastTime = System.currentTimeMillis()
     } })