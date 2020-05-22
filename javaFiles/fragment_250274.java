float opposite = event.getY() - 400;
float adjacent = event.getX() - 400;
float hypotenuse = Math.sqrt(opposite*opposite + adjacent*adjacent);

float cosine = adjacent/hypotenuse;
float sine = opposite/hypotenuse;

float endX = 400 + 50 * cosine;
float endY = 400 + 50 * sine;