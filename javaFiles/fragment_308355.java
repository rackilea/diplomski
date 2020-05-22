if (!this.table.contains(p))
        {
            if(p.y < 0) 
              System.out.println("clicked above table");
            else
              System.out.println("outside table, would be row 
              "+this.table.rowAtPoint(p));
        }