static T[] sectorSort<T>(T[] elements, int sectorWidth, int sectorHeight, int columns, int rows)
        {
            T[] sortedElements = new T[elements.Length];
            int n = 0;
            int arrWidth = sectorWidth * columns;
            for(int secY = 0; secY < rows; secY++)
                for (int secX = 0; secX < columns; secX++)
                {
                    int baseIndex = secY * arrWidth * sectorHeight + secX * sectorWidth;
                    for(int y = 0; y < sectorHeight; y++)
                        for (int x = 0; x < sectorWidth; x++)
                        {
                            int sourceIndex = baseIndex + y * arrWidth + x;
                            sortedElements[n++] = elements[sourceIndex];
                        }
                }
            return sortedElements;
        }