String PythonData = "{'name': u'Shivam', 'otherInfo': [[0], [1]], 'isMale': True}";

String[] cmd = {
    "python", "-c", "import sys, ast, json ; print(json.dumps(ast.literal_eval(sys.argv[1])))",
    python_data
    };
Runtime.getRuntime().exec(cmd);