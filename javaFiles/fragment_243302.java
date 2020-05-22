override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    holder.remove.setOnClickListener {

        val builder = AlertDialog.Builder(context)
        builder.setMessage(R.string.delete_contact)

        builder.setPositiveButton(R.string.yes){_, _ ->
            users.removeAt(holder.getAdapterPosition())
            notifyItemRemoved(holder.getAdapterPosition())
        }

        builder.setNegativeButton(R.string.no){_,_ ->

        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}