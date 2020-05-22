function randomColor(){
  var golden_ratio_conjugate = 0.618033988749895,
      h = (Math.random() + golden_ratio_conjugate) % 1 *360,
      rgb = hsvToRgb(h, 50, 95);
  return "rgb("+rgb[0]+","+rgb[1]+","+rgb[2]+")";
}

/**
 * Converts an HSV color value to RGB. Conversion formula
 * adapted from http://en.wikipedia.org/wiki/HSL_and_HSV.
 * Assumes h is contained in the set [0, 360] and
 * s and l are contained in the set [0, 100] and
 * returns r, g, and b in the set [0, 255].
 *
 * @param   Number  h       The hue
 * @param   Number  s       The saturation
 * @param   Number  v       The value
 * @return  Array           The RGB representation
 */
function hsvToRgb(h, s, v){
  var chroma = s * v / 10000,
      min = v / 100 - chroma,
      hdash = h / 60,
      x = chroma * (1 - Math.abs(hdash % 2 - 1)),
      r = 0, g = 0, b = 0;

  switch(true){
    case hdash < 1:
      r = chroma;
      g = x;
      break;
    case hdash < 2:
      r = x;
      g = chroma;
      break;
    case hdash < 3:
      g = chroma;
      b = x;
      break;
    case hdash < 4:
      g = x;
      b = chroma;
      break;
    case hdash < 5:
      r = x;
      b = chroma;
      break;
    case hdash <= 6:
      r = chroma;
      b = x;
      break;
  }

  r += min;
  g += min;
  b += min;

  return [Math.round(r * 255), Math.round(g * 255), Math.round(b * 255)];
}