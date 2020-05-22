import java.util.List;

String[] chars = myString.split('');
int depth = 0;
int lastMath = 0;
List<String> results = new ArrayList<String>();

for (int i = 0; i < chars.length; i += 1) {
    if (chars[i] === '{') {
        depth += 1;
        if (depth === 1) {
            lastIndex = i;
        }
    }
    if (chars[i] === '}') {
        depth -= 1;
        if (depth === 0) {
            results.add(StringUtils.join(Arrays.copyOfRange(chars, lastIndex, i + 1), ''));
        }
        if (depth < 0) {
            // Balancing problem Handle an error
        }
    }
}