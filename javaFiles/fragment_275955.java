for (L2PcInstance pc : L2World.getInstance().getPlayers())
        {
            if (pc.isOnline() && ((pc.getClient() != null) && !pc.getClient().isDetached()))
            {
                Object[] rowData = new Object[]
                {
                    pc.getAccountName(),
                    pc.getId(),
                    pc.getName(),
                    pc.getLevel(),
                    pc.getCurrentHp(),
                    pc.getCurrentMp(),
                    pc.getCurrentCp(),
                    pc.getPvpKills(),
                    pc.getPkKills(),
                    pc.getBaseClass(),
                    pc.getCreateDate()
                };
                model.addRow(rowData);
            }
break;

        }

//call a new method here