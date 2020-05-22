panel(id:'main') {
    panel {   
      button(name:'x', action: action(name:'add', closure:{p.add(label('new')); p.revalidate()}))
      button(action: action(name:'remove', closure:{p.removeAll();p.revalidate();scroll.repaint()}))
    }

    panel() {
      scrollPane(id:'scroll',preferredSize: [200,200], constraints: context.CENTER) {
        panel(id:'p') {
          checkBoxList(listData: (1..20).collect([]){"Option $it"} as Object[])
        }
      }
    }
  }