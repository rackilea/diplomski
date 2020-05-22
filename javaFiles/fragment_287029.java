BMD0.Model.ModelData.Material.MatDef mat = (BMD0.Model.ModelData.Material.MatDef) model.model.mdlData[0].material.material[i];
            ImageData tmp_tex = Nsbtx.getTexture(tex, mat.texID, mat.palID).getImageData();
            gl.glBindTexture(GL2.GL_TEXTURE_2D, texturesID.get(i));
            ByteBuffer tmp_tex_data = ByteBuffer.allocate(tmp_tex.height * tmp_tex.width * 4);
            PaletteData pal = tmp_tex.palette;
            for (int h = 0; h < tmp_tex.height; h++) {
                for (int w = 0; w < tmp_tex.width; w++) {
                    tmp_tex_data.put((byte) pal.getRGB(tmp_tex.getPixel(w, h)).red);
                    tmp_tex_data.put((byte) pal.getRGB(tmp_tex.getPixel(w, h)).green);
                    tmp_tex_data.put((byte) pal.getRGB(tmp_tex.getPixel(w, h)).blue);
                    tmp_tex_data.put((byte) tmp_tex.getAlpha(w, h));
                }
            }
            tmp_tex_data.flip();
            gl.glTexImage2D(GL2.GL_TEXTURE_2D, 0, GL2.GL_RGBA, tmp_tex.width, tmp_tex.height, 0, GL2.GL_RGBA, GL2.GL_UNSIGNED_BYTE, tmp_tex_data);
            texturesGL.put(i, texturesID.get(i));