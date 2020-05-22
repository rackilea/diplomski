String htmlData = listData.get(position).getValue();
               String showData = htmlData.replace("\n", "");

                URLImageParser p = new URLImageParser(holder.textt, context);
                Spanned htmlAsSpanned = Html.fromHtml(showData,p,null);

                holder.yourTextView.setText(htmlAsSpanned);