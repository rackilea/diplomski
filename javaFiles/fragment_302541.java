byte[] buff = new byte[Config.TINY_GRID_SIZE * 2];
        TinyGridContainer tinyGrid = bytePool.obtain();
        for (int ty = 0; ty < Config.TINY_GRID_SIZE; ty++)
            for (int tz = 0; tz < Config.TINY_GRID_SIZE; tz++) {
                int cnt = 0;
                for (int tx = 0; tx < Config.TINY_GRID_SIZE; tx++) {
                    int id = tx * 2;

                    if (cnt <= id) {
                        cnt += in.read(buff, cnt, buff.length - cnt);
                    }

                    tinyGrid.grid[tx][ty][tz] = (short) ((buff[id] >> 2) & 0xff);

                    id++;
                    if (cnt <= id) {
                        cnt += in.read(buff, cnt, buff.length - cnt);
                    }

                    tinyGrid.grid[tx][ty][tz] += (short) (buff[id] & 0xff);
                }
            }