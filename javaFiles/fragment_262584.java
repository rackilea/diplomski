int HI = 0; int LO = 1;
int left = (buff[i * 4 + HI] << 8) | (buff[i * 4 + LO] & 0xff);
int right = (buff[i * 4 + 2 + HI] << 8) | (buff[i * 4 + 2 + LO] & 0xff);
int avg = (left + right) / 2;
mono[i * 2 + HI] = (byte)((avg >> 8) & 0xff);
mono[i * 2 + LO] = (byte)(avg & 0xff);