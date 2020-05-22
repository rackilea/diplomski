for (HashMap<String, String> cartaInventario : listaCartasInventario) {
            cartasInventario.add(cartaInventario.get(Config.TAG_ID_CARTA_INVENTARIO));
            for (HashMap<String, String> cartaDeckInventario : listaCartasDeckInventario) {
                if(cartaInventario.get(Config.TAG_ID_CARTA_INVENTARIO).equals(cartaDeckInventario.get(Config.TAG_ID_CARTA_DECKINVENTARIO)))
                {
                    cartasInventario.remove(cartaInventario.get(Config.TAG_ID_CARTA_INVENTARIO));
                    break;
                }
            }
        }