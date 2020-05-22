if(dto.getImageUrl() != null) {             
    try {
    URL imageUrl = new URL(dto.getImageUrl());
    itemDO.setImage(convertImageByte(imageUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    entity = orderItemRepository.save(itemDO);