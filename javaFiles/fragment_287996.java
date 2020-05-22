vh.qnt=(Button) convertView.findViewById(R.id.qnt);

        vh.quantidade=new Quantidade[itens.size()];
        for(int i=0;i<itens.size();i++){
            b[i]=(Button)conv.findViewById(R.id.qnt);
            vh.quantidade[i].quantidade=1;
            vh.quantidade[i].order=i;
        }