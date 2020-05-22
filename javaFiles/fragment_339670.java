const NAMES = ['Spring', 'Summer', 'Fall'];
const OFFSET = 2002;

const numberMap = new Map<number, Semester>();
const labelMap = new Map<string, Semester>();

export interface SemesterOptions {
    semesterNumber?: number
    label?: string
}

export class Semester {
    private semesterNumber: number;
    private label: string;

    constructor({ semesterNumber, label }: SemesterOptions) {
        if (semesterNumber === undefined) {
            if (label === undefined) {
                throw new Error('invalid options');
            }
            const parsed = parseLabelToSemesterOptions(label);
            semesterNumber = parsed.semesterNumber;
            label = parsed.label;
        } else if (label === undefined) {
            if (semesterNumber < 1) {
                throw new Error('Semester number cannot be less than 1');
            }
            label = NAMES[semesterNumber % NAMES.length] + ' ' + (semesterNumber / 3 + OFFSET);
        }

        this.semesterNumber = semesterNumber;
        this.label = label;
    }


    static ofNumber(semesterNumber: number): Semester {
        let semester = numberMap.get(semesterNumber);
        if (!semester) {
            semester = new Semester({ semesterNumber });
            numberMap.set(semester.semesterNumber, semester);
            if (!labelMap.has(semester.label)) {
                labelMap.set(semester.label, semester);
            }
        }
        return semester; 
    }

    static ofLabel(label: string): Semester {
        let semester = labelMap.get(label);
        if (!semester) {
            semester = new Semester({ label });
            labelMap.set(semester.label, semester);
            if (!numberMap.has(semester.semesterNumber)) {
                numberMap.set(semester.semesterNumber, semester);
            }
        }
        return semester; 
    }
}

function parseLabelToSemesterOptions(labelToParse: string): Required<SemesterOptions> {
    const tokens = labelToParse.split('\\ ');
    if (tokens.length !== 2) {
        throw new Error('Semester label has incorrect number of tokens');
    }
    const label = tokens[0];
    const year = parseInt(tokens[1], 10);
    if (year < OFFSET) {
        throw new Error('Year cannot be earlier than ' + OFFSET);
    }
    const nameIndex = NAMES.indexOf(label);
    if (nameIndex === -1) {
        throw new Error(`Name of the semester must be one of ${NAMES.join(', ')}`);
    }
    const semesterNumber = (year - OFFSET) * 3 + nameIndex;
    return {
        semesterNumber,
        label
    }
}