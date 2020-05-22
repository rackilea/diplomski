int cols = matrix[row].length;

            int nextColValue = col+1 < cols ? matrix[row][col+1] : 0;
            int lastColValue = col-1 >= 0 ? matrix[row][col-1] : 0;

            ... + nextColValue + lastColValue + ...