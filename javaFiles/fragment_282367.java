//Calculate left
            float left_x1 = current.x;
            float left_y1 = current.y;
            float left_x2 = previous.x;
            float left_y2 = previous.y;
            float D = 30;

            float left_dx = left_x1-left_x2;
            float left_dy = left_y1-left_y2;
            float left_dist = (float) Math.sqrt(left_dx*left_dx + left_dy*left_dy);
            left_dx /= left_dist;
            left_dy /= left_dist;
            float left_x3 = left_x1 + D * left_dy;
            float left_y3 = left_y1 - D * left_dx;
            float left_x4 = left_x1 - D * left_dy;
            float left_y4 = left_y1 + D * left_dx;

            //Calculate right
            float right_x1 = previous.x;
            float right_y1 = previous.y;
            float right_x2 = old.x;
            float right_y2 = old.y;

            float right_dx = right_x1-right_x2;
            float right_dy = right_y1-right_y2;
            float dist = (float) Math.sqrt(right_dx*right_dx + right_dy*right_dy);
            right_dx /= dist;
            right_dy /= dist;
            float right_x3 = right_x1 + D * right_dy;
            float right_y3 = right_y1 - D * right_dx;
            float right_x4 = right_x1 - D * right_dy;
            float right_y4 = right_y1 + D * right_dx;

            //Draw bounds
            shapeRenderer.line(right_x3, right_y3, left_x3, left_y3);
            shapeRenderer.line(right_x4, right_y4, left_x4, left_y4);