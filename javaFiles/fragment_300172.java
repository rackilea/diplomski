private fun channelPopup(){

        //   addDummyProfile()
        channelDialog = Dialog(context)
        channelDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val lp = channelDialog!!.getWindow()!!.getAttributes()
        val window = channelDialog!!.getWindow()
        window!!.setGravity(Gravity.CENTER)
        channelDialog!!.getWindow()!!.setAttributes(lp)
        channelDialog!!.getWindow()!!.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        channelDialog!!.setCanceledOnTouchOutside(true)
        channelDialog!!.setCancelable(true)
        channelDialog!!.setContentView(R.layout.exitsing_channel_layout)
        val tv_videos_no: TextView = channelDialog!!.findViewById(R.id.tv_videos_no) as TextView
        val recycler_channel = channelDialog!!.findViewById<RecyclerView>(R.id.recycler_channel)
        recycler_channel!!.layoutManager= LinearLayoutManager(context)
        channelAdapter = ChannelAdapter(tv_videos_no)
        recycler_channel!!.adapter = channelAdapter
        channelDialog!!.show()
    }